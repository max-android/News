package com.myexamplenews.news.model.pojo;

import com.myexamplenews.news.ui.general.Constants;

import org.simpleframework.xml.convert.Converter;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

/**
 * Created by Максим on 16.03.2018.
 */

public class ItemConverter implements Converter<Item> {

    @Override
    public Item read(InputNode node) throws Exception {

        Item item=null;

        InputNode child = node.getNext("enclosure");

        Enclosure  enclosure=null;

        if(child!=null){

          enclosure = new Persister().read(Enclosure.class,child);

        }else{

            enclosure=new Enclosure(Constants.IMAGE);

        }

        InputNode child_title = node.getNext("title");
        String title=new Persister().read(child_title.getValue(),child_title);


        InputNode child_date= node.getNext("pubDate");
        String date=new Persister().read(child_date.getValue(),child_date);

        InputNode child_full = node.getNext("full-text");
        String full=new Persister().read(child_full.getValue(),child_full);


        item=new Item(title,date,enclosure,full);


        return item;
      //  throw new UnsupportedOperationException("Not supported yet.");
       // return  null;
    }

    @Override
    public void write(OutputNode node, Item value) throws Exception {


        if(value.getEnclosure()!=null){

            node.getChild("enclosure").setValue(value.getEnclosure().toString());

        }else{

            node.getChild("enclosure").setValue(new Enclosure(Constants.IMAGE).toString());


        }

         node.setValue(value.getTitle());
         node.setValue(value.getFulltext());
         node.setValue(value.getPubDate());

   }
}















//    Enclosure enclosure=null;
//
//        if(node.getNext("enclosure")==null){
//
//                enclosure=new Enclosure(Constants.IMAGE);
//
//                }




  //  final Example val = (Example) value;
//        final List<Object> l = val.getValueUnion();
//
//        if( !l.isEmpty() ) // if there are elements, insert their nodes
//        {
//            for( Object obj : l )
//            {
//                node.getChild("values").setValue(obj.toString());
//            }
//        }
//        else
//        {
//            node.getChild("values").setValue(""); // this creates <values></values> if list is empty
//        }
//        node.setValue(val.getText());