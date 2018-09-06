package me.study.rxstudys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import javax.security.auth.login.LoginException;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import me.study.rxstudys.beans.Repo;
import me.study.rxstudys.rxjavas.apis.GitHubApi;
import me.study.rxstudys.utils.ThreadPoolsUtils;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initData();

    }


    private void initData() {

        GitHubApi.getInstance().getReposApiService()
                .listRepos("GentleLi")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Repo>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "onSubscribe");
                    }

                    @Override
                    public void onNext(List<Repo> repos) {
                        Log.e(TAG, "onSubscribe");
                        if (null == repos || repos.size() <= 0) {
                            return;
                        }

                        for (Repo repo :
                                repos) {
                            if (null != repo) {
                                Log.e(TAG, "repo full name >> " + repo.getFull_name());
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "onComplete");
                    }
                });


    }
}
