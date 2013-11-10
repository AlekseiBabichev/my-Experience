package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created with IntelliJ IDEA.
 * User: aleksei
 * Date: 09.06.13
 * Time: 19:23
 * To change this template use File | Settings | File Templates.
 */
public class ImageReaderFactory
{
    static ImageReader getReader( ImageTypes imgType )
    {
        ImageReader imgReader;

        if ( imgType == ImageTypes.BMP )
        {
            imgReader = new BmpReader();
        }
        else if ( imgType == ImageTypes.JPG )
        {
            imgReader = new JpgReader();
        }
        else if ( imgType == ImageTypes.PNG )
        {
            imgReader = new PngReader();
        }
        else
        {
            throw new IllegalArgumentException( "Неизвестный тип картинки" );
        }

        return imgReader;
    }
}
