package com.example.sort.mvp.view;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.mvpcore.view.MVPFragment;
import com.example.protocol.BaseReposEntity;
import com.example.sort.R;
import com.example.sort.adapter.CarAdapter;
import com.example.sort.adapter.ShopAdapter;
import com.example.sort.adapter.UserAdapter;
import com.example.sort.entity.ShopEntity;
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
 * @ClassName CarFragment
 * @Description TODO
 * @Author Zhi Qiang
 * @Email 1745984453@qq.com
 * @Date 2021/10/7 21:42
 * @Version 1.0
 * @ClassDescription
 */
public class CarFragment extends MVPFragment implements CarView {

    List<ShopEntity> list = new ArrayList<>();
    RecyclerView showViewRecyc;
    Button toPay;
    TextView money;
    private CarComponent carComponent;
    private CarAdapter carAdapter;
    private ShopAdapter shopdapter;


    @Inject
    CarPresenter carPresenter;

    @Override
    public void initEvent() {

    }

    @Override
    public void initView() {

        showViewRecyc = (RecyclerView) findView(R.id.car_recy);
        toPay = (Button) findView(R.id.car_pay_btn);
        money = (TextView) findView(R.id.money);
    }

    @Override
    public void initData() {
//        CarPresenter carPresenter = new CarPresenter();
//        carPresenter.getList();

        //支付按钮
        toPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "去支付", Toast.LENGTH_SHORT).show();
                ARouter.getInstance().build("/Pay/activity").navigation();
            }
        });

        list.add(new ShopEntity("https://img13.360buyimg.com/n7/jfs/t2590/338/4222589387/237425/25e40fb/57b12ac6N61374a75.jpg",100L));
        list.add(new ShopEntity("https://img14.360buyimg.com/n7/jfs/t3556/223/2158676156/110226/59267230/584b5678Nbc9f1e70.jpg",100L));

        showViewRecyc.setLayoutManager(new LinearLayoutManager(getActivity()));
        shopdapter = new ShopAdapter(list);
        showViewRecyc.setAdapter(shopdapter);
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
//        showViewRecyc.setLayoutManager(new LinearLayoutManager(getActivity()));
//        carAdapter = new CarAdapter(entity);
//        showViewRecyc.setAdapter(carAdapter);
//        shopdapter = new ShopAdapter(list);
//        showViewRecyc.setAdapter(shopdapter);
    }

    @Override
    public void failed(@NotNull Throwable throwable) {
        Log.i("123", "failed: "+throwable);
    }

}
