package iherrera.cursokotlin.com.Section_01.Activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import iherrera.cursokotlin.com.R
import iherrera.cursokotlin.com.Section_01.Utils.CircleTransform
import kotlinx.android.synthetic.main.activity_picasso.*
import java.lang.Exception

class PicassoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picasso)

        buttonLoader.setOnClickListener { _loadImages() }
        // Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(imageView);
        Picasso.get().load("https://images.pexels.com/photos/2947337/pexels-photo-2947337.jpeg").fetch()
    }

    private fun _loadImages() {
        Picasso
            .get()
            .load("https://images.pexels.com/photos/2947337/pexels-photo-2947337.jpeg")
            .resize(300, 300)
            .centerInside()
            .transform(CircleTransform()) // Circle
            .into(imageViewTop)

        /*Picasso
            .get()
            .load("https://images.pexels.com/photos/825947/pexels-photo-825947.jpeg")
            .fit()
            .into(imageViewBottom)*/

       /* Picasso
            .get()
            .load("https://images.pexels.com/photos/825947/pexels-photo-825947.jpeg")
            .fit()
            .transform(CircleTransform()) // Circle
            .into(imageViewBottom)
       */

        Picasso
            .get()
            .load("https://images.pexels.com/photos/825947/pexels-photo-825947.jpeg")
            .fetch(object: Callback {
                override fun onSuccess() {
                    imageViewBottom.alpha = 0f
                    Picasso
                        .get()
                        .load("https://images.pexels.com/photos/825947/pexels-photo-825947.jpeg")
                        .fit()
                        .into(imageViewBottom)

                    imageViewBottom.animate().setDuration(1300).alpha(1f).start()
                }

                override fun onError(e: Exception?) {
                    TODO("Not yet implemented")
                }

            })
    }
}