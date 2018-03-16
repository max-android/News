package com.myexamplenews.news.model.pojo;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

import java.io.Serializable;

/**
 * Created by Максим on 14.03.2018.
 */
@Root(name="item", strict=false)
public class Item implements Serializable {




//    @Path("title")
//    @Text(required=false)
    @Element(name="title")
    private String title;

    @Element(name="pubDate")
    private String pubDate;


   // @Element(name="enclosure")
    @Path("enclosure")
    @Text(required=false)
    @Element(name="enclosure",required = false)
    private Enclosure enclosure;


   // @Element(required = false, name="yandex:full-text")
    @Element(name="full-text")
    @Namespace(reference="", prefix = "yandex")
    private String fulltext;

   // @Element(name="pubDate")
    public String getPubDate ()
    {
        return pubDate;
    }

    //@Element(name="pubDate")
    public void setPubDate (String pubDate)
    {
        this.pubDate = pubDate;
    }


   // @Element(name="title")
    public String getTitle ()
    {
        return title;
    }

   // @Element(name="title")
    public void setTitle (String title)
    {
        this.title = title;
    }
   // @Element(name="enclosure")
    public Enclosure getEnclosure ()
    {
        return enclosure;
    }
    //@Element(name="enclosure")
    public void setEnclosure (Enclosure enclosure)
    {
        this.enclosure = enclosure;
    }

   // @Element(required = false, name="yandex:full-text")
    public String getFulltext() {
        return fulltext;
    }

   // @Element(required = false, name="yandex:full-text")
    public void setFulltext(String fulltext) {
        this.fulltext = fulltext;
    }


    public Item(String title, String pubDate, Enclosure enclosure, String fulltext) {
        this.title = title;
        this.pubDate = pubDate;
        this.enclosure = enclosure;
        this.fulltext = fulltext;
    }

    public Item() {

    }
}
