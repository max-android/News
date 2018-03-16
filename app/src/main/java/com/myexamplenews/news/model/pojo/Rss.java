package com.myexamplenews.news.model.pojo;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import java.io.Serializable;

/**
 * Created by Максим on 14.03.2018.
 */

@Root(name="rss", strict=false)
public class Rss implements Serializable {


   // @Element(name = "channel")
    private Channel channel;


    @Element(name = "channel")
    public Channel getChannel() {
        return channel;
    }


    @Element(name = "channel")
    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public Rss(){

    }

}
