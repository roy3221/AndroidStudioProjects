package com.example.churong1.trailproject.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.churong1.trailproject.APIs.API;
import com.example.churong1.trailproject.APIs.JsonToObjects;
import com.example.churong1.trailproject.Adapter.ImageAdapter;
import com.example.churong1.trailproject.R;
import com.example.churong1.trailproject.model.Looks;
import com.example.churong1.trailproject.model.outFitProduct;

import java.io.InputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView ShowResponse;
    private ImageView[] imageTests;
    private ImageView LookImage;
    public static JsonToObjects JTO;
    private Looks look;

    private ImageAdapter imageAdapter;

    public MainActivity() {
        this.JTO = getLooks();
        this.look = JTO.getLooks().get(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ShowResponse = (TextView) findViewById(R.id.ShowResponse);
//        ShowResponse.setText(JTO.getProductIdList(0).get(0));
        LookImage = (ImageView) findViewById(R.id.LookImage);
        imageTests = new ImageView[5];
        imageTests[0] = (ImageView) findViewById(R.id.imageTest);
        imageTests[1] = (ImageView) findViewById(R.id.imageTest1);
        imageTests[2] = (ImageView) findViewById(R.id.imageTest2);
        imageTests[3] = (ImageView) findViewById(R.id.imageTest3);
        imageTests[4] = (ImageView) findViewById(R.id.imageTest4);
        imageAdapter = new ImageAdapter();
        setLookImage();
        addImages();

    }

    public void setLookImage() {
        LookImage.setMaxWidth(look.getImage_width());
        LookImage.setMaxHeight(look.getImage_height());
        LookImage.setX(0);
        new DownloadImageTask(LookImage)
                .execute(look.getImage_url());
    }

    public void addImages() {
        List<outFitProduct> productList = JTO.getAllProducts(0);
        for(int i = 0; i < imageTests.length; i++) {
            outFitProduct product = productList.get(i);
            float[] coordinate = getImagePosiiton(product);

            imageTests[i].setMaxHeight(product.getImage_height());
            imageTests[i].setMaxWidth(product.getImgae_width());
//            imageTests[i].set

//            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
//            params.addRule(RelativeLayout., button1.getId());

            new DownloadImageTask(imageTests[i])
                    .execute(product.getImage_url());
        }

    }

    public float[] getImagePosiiton(outFitProduct product) {
        int lookWidth = look.getImage_width();
        int lookHeight = look.getImage_height();
        float[] coordinate = new float[4];
        coordinate[0] = product.getX_0() * lookHeight;
        coordinate[1] = product.getY_0() * lookWidth;
        coordinate[2] = product.getX_1() * lookHeight;
        coordinate[3] = product.getY_1() * lookWidth;
        return coordinate;
    }


    public JsonToObjects getLooks() {
        API api = new API();

        Thread thread = new Thread(api);
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String getResponse = api.getJsonResponse();
        JsonToObjects jsonToObjects = new JsonToObjects();
        jsonToObjects.transfer(getResponse);
        return jsonToObjects;
    }


    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
