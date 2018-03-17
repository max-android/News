package com.myexamplenews.news.model.pojo;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

import java.io.Serializable;

/**
 * Created by Максим on 14.03.2018.
 */
@Root(name="enclosure", strict=false)
public class Enclosure implements Serializable {

//    @Attribute(name="height")
//    private String height;
//
//
//     @Attribute(name="width")
//    private String width;
//
//
//     @Attribute(name="type")
//    private String type;

     @Attribute(name="url")
    private String url;
//
//
//   // @Attribute(name="height")
//    public String getHeight ()
//    {
//        return height;
//    }
//   // @Attribute(name="height")
//    public void setHeight (String height)
//    {
//        this.height = height;
//    }
//
//
//   // @Attribute(name="width")
//    public String getWidth ()
//    {
//        return width;
//    }
//   // @Attribute(name="width")
//    public void setWidth (String width)
//    {
//        this.width = width;
//    }
//   // @Attribute(name="type")
//    public String getType ()
//    {
//        return type;
//    }
//    //@Attribute(name="type")
//    public void setType (String type)
//    {
//        this.type = type;
//    }



  //  @Attribute (name="url")
    public String getUrl ()
    {
        return url;
    }


   // @Attribute (name="url")
    public void setUrl (String url)
    {
        this.url = url;
    }


//    public Enclosure(@Attribute(name="url")String url) {
//        this.url = url;
//    }


    public Enclosure(String url) {
        this.url = url;
    }

    public Enclosure() {

    }

//    public Enclosure(String height, String width, String type, String url) {
//        this.height = height;
//        this.width = width;
//        this.type = type;
//        this.url = url;
//    }


}
