package me.study.rxstudys.rxjavas.apis;

import java.util.List;

import io.reactivex.Observable;
import me.study.rxstudys.beans.Repo;
import me.study.rxstudys.rxjavas.service.ReposService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 2018/9/5.
 */

public class GitHubApi {

    private static final String TAG = GitHubApi.class.getSimpleName();

    private static GitHubApi mInstance;

    private GitHubApi() {
        
    }

    public static GitHubApi getInstance() {
        if (null == mInstance) {
            synchronized (GitHubApi.class) {
                if (null == mInstance) {
                    mInstance = new GitHubApi();
                }
            }
        }
        return mInstance;
    }

    public ReposService getReposApiService() {
        //获取实例
        Retrofit retrofit = new Retrofit.Builder()
                //设置OKHttpClient,如果不设置会提供一个默认的
                .client(new OkHttpClient())
                //设置baseUrl
                .baseUrl("https://api.github.com/")
                //添加Gson转换器
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ReposService service = retrofit.create(ReposService.class);
        return service;
    }


}

