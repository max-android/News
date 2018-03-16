package com.myexamplenews.news.model.pojo;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Максим on 14.03.2018.
 */
@Root(name="channel", strict=false)
public class Channel implements Serializable {

  //  @ElementList(name="item")
    private List<Item> item;

    @ElementList(name="item", inline = true)
    public List<Item> getItem() {
        return item;
    }


    @ElementList(name="item", inline = true)
    public void setItem(List<Item> item) {
        this.item = item;
    }

    public  Channel(){

    }


}
