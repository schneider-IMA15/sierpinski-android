package at.fh.swengb.sierpinski_android.model

import android.graphics.Canvas
import android.graphics.Paint

class Triangle(var Ax: Double, var Ay: Double, var Bx: Double, var By: Double, var Cx: Double, var Cy: Double, var recCount: Int, val canvas: Canvas) {
  private[model] val paint: Paint = new Paint
  canvas.drawLine(this.Ax.toFloat, this.Ay.toFloat, this.Bx.toFloat, this.By.toFloat, paint)
  canvas.drawLine(this.Ax.toFloat, this.Ay.toFloat, this.Cx.toFloat, this.Cy.toFloat, paint)
  canvas.drawLine(this.Bx.toFloat, this.By.toFloat, this.Cx.toFloat, this.Cy.toFloat, paint)
}
