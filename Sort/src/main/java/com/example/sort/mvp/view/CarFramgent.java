package com.example.sort.mvp.view;

import android.util.Log;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvpcore.view.MVPFragment;
import com.example.protocol.BaseReposEntity;
import com.example.sort.R;
import com.example.sort.adapter.CarAdapter;
import com.example.sort.adapter.UserAdapter;
import com.example.sort.mvp.injection.component.CarComponent;
import com.example.sort.mvp.injection.component.DaggerCarComponent;
import com.example.sort.mvp.injection.module.CarModule;
import com.example.sort.mvp.injection.module.CarViewModule;
import com.example.sort.mvp.model.entity.CarEntity;
import com.example.sort.mvp.presenter.CarPresenter;
import com.example.stockpile.DaoUser;
import com.example.stockpile.User;
import com.example.util.utils.GlideUtils;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * @CreateDate: 2021/9/23 16:22
 * @name:haonan
 * @Contact information:qq by 1612258670
 * @ProjectName: DS
 * @Package: com.example.sort.mvp.view
 * @ClassName: CarFramgent
 */
public class CarFramgent extends MVPFragment implements CarView {

    RecyclerView showViewRecyc;
    private CarComponent carComponent;
    private CarAdapter carAdapter;

    @Inject
    CarPresenter carPresenter;

    @Override
    public void initEvent() {

    }

    @Override
    public void initView() {

        showViewRecyc = (RecyclerView) findView(R.id.show_view_recyc);
    }

    @Override
    public void initData() {
//        CarPresenter carPresenter = new CarPresenter();
//        carPresenter.getList();

    }

    @Override
    public int getLayoutId() {
        return R.layout.framgent_car_show;
    }

    @Override
    public void initInjection() {
       carComponent = DaggerCarComponent.builder().activityComponent(getActivityComponent())
                .carModule(new CarModule())
                .carViewModule(new CarViewModule(this))
                .build();
       carComponent.getCarFramgent(this);
       carPresenter.getList();
    }

    @Override
    public void success(@NotNull BaseReposEntity<CarEntity> entity) {
        showViewRecyc.setLayoutManager(new LinearLayoutManager(getActivity()));
        carAdapter = new CarAdapter(entity);
        showViewRecyc.setAdapter(carAdapter);
    }

    @Override
    public void failed(@NotNull Throwable throwable) {
        Log.i("123", "failed: "+throwable);
    }

}
