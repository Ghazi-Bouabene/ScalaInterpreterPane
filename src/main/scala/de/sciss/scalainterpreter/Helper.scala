/*
 *  Helper.scala
 *  (ScalaInterpreterPane)
 *
 *  Copyright (c) 2010-2015 Hanns Holger Rutz. All rights reserved.
 *
 *  This software is published under the GNU Lesser General Public License v2.1+
 *
 *  For further information, please contact Hanns Holger Rutz at
 *  contact@sciss.de
 */

package de.sciss.scalainterpreter

import java.awt.{Font, GraphicsEnvironment}

import scala.collection.immutable.{Seq => ISeq}

private[scalainterpreter] object Helper {
  val defaultFonts = ISeq[(String, Int)](
    "Menlo"                     -> 12,
    "DejaVu Sans Mono"          -> 12,
    "Bitstream Vera Sans Mono"  -> 12,
    "Monaco"                    -> 12,
    "Anonymous Pro"             -> 12
  )

  def createFont(list: ISeq[(String, Int)]): Font = {
    val allFontNames = GraphicsEnvironment.getLocalGraphicsEnvironment.getAvailableFontFamilyNames
    val (fontName, fontSize) = list.find(spec => allFontNames.contains(spec._1))
      .getOrElse("Monospaced" -> 12)

    new Font(fontName, Font.PLAIN, /*if( isMac )*/ fontSize /*else fontSize * 3/4*/)
  }
}
