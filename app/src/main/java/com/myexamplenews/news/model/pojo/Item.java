package com.myexamplenews.news.model.pojo;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.convert.Convert;
import java.io.Serializable;

/**
 * Created by Максим on 14.03.2018.
 */
@Root(name="item", strict=false)
@Convert(ItemConverter.class)
public class Item implements Serializable {


    @Element(name="title")
    private String title;

    @Element(name="pubDate")
    private String pubDate;



    @Path("enclosure")
    @Element(required =false ,name="enclosure")
    private Enclosure enclosure;


    @Element(name="full-text")
    @Namespace(reference="", prefix = "yandex")
    private String fulltext;


    public String getPubDate ()
    {
        return pubDate;
    }


    public void setPubDate (String pubDate)
    {
        this.pubDate = pubDate;
    }



    public String getTitle ()
    {
        return title;
    }


    public void setTitle (String title)
    {
        this.title = title;
    }

    public Enclosure getEnclosure ()
    {
        return enclosure;
    }

    public void setEnclosure (Enclosure enclosure)
    {
        this.enclosure = enclosure;
    }


    public String getFulltext() {
        return fulltext;
    }


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
