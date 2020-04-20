/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_memorygame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author barry
 */
public class ResizableImageView extends ImageView
{
    ResizableImageView()
    {
//        setPreserveRatio(false);
    }
    ResizableImageView(Image image)
    {
        super(image);
        setPreserveRatio(true);
    }

    @Override
    public double minWidth(double height)
    {
        return 40;
    }

    @Override
    public double prefWidth(double height)
    {
        Image I=getImage();
        if (I==null) return minWidth(height);
        return I.getWidth();
    }

    @Override
    public double maxWidth(double height)
    {
        return 16384;
    }

    @Override
    public double minHeight(double width)
    {
        return 40;
    }

    @Override
    public double prefHeight(double width)
    {
        Image I=getImage();
        if (I==null) return minHeight(width);
        return I.getHeight();
    }

    @Override
    public double maxHeight(double width)
    {
        return 16384;
    }

    @Override
    public boolean isResizable()
    {
        return true;
    }

    @Override
    public void resize(double width, double height)
    {
        setFitWidth(width);
        setFitHeight(height);
    }
}
