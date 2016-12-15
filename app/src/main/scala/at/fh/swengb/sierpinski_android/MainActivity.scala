package at.fh.swengb.sierpinski_android

import android.graphics.Canvas
import android.graphics.Point
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Display
import at.fh.swengb.sierpinski_android.model.DrawView
import at.fh.swengb.sierpinski_android.model.Triangle
import java.lang.Math.sqrt

class MainActivity extends AppCompatActivity {
  private[sierpinski_android] var drawView: DrawView = null

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)

    val display: Display = getWindowManager.getDefaultDisplay
    val size: Point = new Point
    display.getSize(size)

    val margin: Int = 20
    val bottom: Int = 1000 - margin
    val screenWidth: Int = size.x

    val startTri: Triangle = new Triangle(0 + margin, bottom + margin, ((screenWidth - 2 * margin) / 2) + margin, (bottom - (sqrt(3) / 2) * (screenWidth - 2 * margin)) + margin, (screenWidth - 2 * margin) + margin, bottom + margin, 0, new Canvas)
    drawView = new DrawView(this, startTri)
    setContentView(drawView)
  }
}
