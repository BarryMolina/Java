/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_memorygame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class creates a specialized ImageView object that can be resized.
 */
public class ResizableImageView extends ImageView
{
    /**
     * The default constructor.
     */
    ResizableImageView()
    {
//        setPreserveRatio(false);
    }
    /**
     * This constructor takes an Image object and displays it.
     * @param image 
     */
    ResizableImageView(Image image)
    {
        super(image);
        setPreserveRatio(true);
    }

    /**
     * Returns a minimum width given a specific height.
     * @param height The specified height.
     * @return The minimum width for this height.
     */
    @Override
    public double minWidth(double height)
    {
        return 40;
    }

    /**
     * Returns a preferred width given a specific height.
     * @param height The specified height.
     * @return The preferred width for this height.
     */
    @Override
    public double prefWidth(double height)
    {
        // Get the image associated with this ImageView
        Image I = getImage();
        // If there is no Image.
        if (I == null) {
            return minWidth(height);
        }
        else {
            // Return the Image width.
            return I.getWidth();
        }
    }

    /**
     * Returns a maximum width given a specific height.
     * @param height The specified height.
     * @return The maximum width for this height.
     */
    @Override
    public double maxWidth(double height)
    {
        return 16384;
    }

    /**
     * Returns a minimum height given a specific width.
     * @param width The specified width.
     * @return The minimum height for this width.
     */
    @Override
    public double minHeight(double width)
    {
        return 40;
    }

    @Override
    public double prefHeight(double width)
    {
        // Get the image associated with this ImageView
        Image I = getImage();
        // If there is no Image.
        if (I == null) {
            return minHeight(width);
        }
        else {
            // Return the Image width.
            return I.getHeight();
        }
    }

    /**
     * Returns a maximum height given a specific width.
     * @param width The specified width.
     * @return The maximum height for this width.
     */
    @Override
    public double maxHeight(double width)
    {
        return 16384;
    }

    /**
     * Returns whether this ImageView is resizable.
     * @return Whether this ImageView is resizable.
     */
    @Override
    public boolean isResizable()
    {
        return true;
    }

    /**
     * Sets the height and width to specified values.
     * @param width The width to set.
     * @param height  The height to set.
     */
    @Override
    public void resize(double width, double height)
    {
        setFitWidth(width);
        setFitHeight(height);
    }
}
