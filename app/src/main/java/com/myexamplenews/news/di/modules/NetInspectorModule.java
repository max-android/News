package com.myexamplenews.news.di.modules;

import android.content.Context;
import com.myexamplenews.news.ui.general.NetInspector;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;



@Module
@Singleton
public class NetInspectorModule {


    private Context context;

    public NetInspectorModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public NetInspector provideNetInspector(){

        return new NetInspector(context);
    }
}
