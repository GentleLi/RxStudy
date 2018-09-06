package me.study.rxstudys.rxjavas.service;

import java.util.List;

import io.reactivex.Observable;
import me.study.rxstudys.beans.Repo;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by admin on 2018/9/5.
 */

public interface ReposService {

    @GET("users/{user}/repos")
    Observable<List<Repo>> listRepos(@Path("user") String user);


}
