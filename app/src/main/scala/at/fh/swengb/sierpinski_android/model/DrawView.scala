package at.fh.swengb.sierpinski_android.model

/**
  * Created by Lukas Schneider on 09.12.2016.
  */

import android.content.Context
import android.graphics.Canvas
import android.view.View

class DrawView(val context: Context, var startTri: Triangle) extends View(context) {
  private[model] val recCtrl: Int = 8

  override def onDraw(canvas: Canvas) {
    new Triangle(startTri.Ax, startTri.Ay, startTri.Bx, startTri.By, startTri.Cx, startTri.Cy, startTri.recCount, canvas)
    val firstT: Triangle = new Triangle((startTri.Ax + startTri.Bx) / 2, (startTri.Ay + startTri.By) / 2, (startTri.Ax + startTri.Cx) / 2, (startTri.Ay + startTri.Cy) / 2, (startTri.Bx + startTri.Cx) / 2, (startTri.By + startTri.Cy) / 2, 1, canvas)
    recursion(firstT, canvas)
  }

  def recursion(t: Triangle, c: Canvas) {
    val newTLeft: Triangle = new Triangle(t.Ax - (t.Cx - t.Ax) / 4, (t.Ay + t.By) / 2, t.Ax, t.By, t.Ax + (t.Cx - t.Ax) / 4, (t.Ay + t.By) / 2, t.recCount + 1, c)
    val newTRight: Triangle = new Triangle((t.Bx + t.Cx) / 2, (t.By + t.Cy) / 2, t.Cx, t.By, t.Cx + (t.Cx - t.Ax) / 4, (t.By + t.Cy) / 2, t.recCount + 1, c)
    val newTTop: Triangle = new Triangle(t.Ax + (t.Cx - t.Ax) / 4, t.Ay - (t.By - t.Ay) / 2, (t.Ax + t.Cx) / 2, t.Ay, (t.Bx + t.Cx) / 2, t.Ay - (t.By - t.Ay) / 2, t.recCount + 1, c)
    if (t.recCount + 1 < recCtrl) {
      recursion(newTLeft, c)
      recursion(newTRight, c)
      recursion(newTTop, c)
    }
  }
}