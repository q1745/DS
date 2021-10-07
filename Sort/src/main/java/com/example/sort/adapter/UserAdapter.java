package com.example.sort.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.sort.R;
import com.example.stockpile.User;
import com.example.util.utils.GlideUtils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @CreateDate: 2021/9/24 9:08
 * @name:haonan
 * @Contact information:qq by 1612258670
 * @ProjectName: DS
 * @Package: com.example.sort.adapter
 * @ClassName: UserAdapter
 */
public class UserAdapter extends BaseQuickAdapter<User, BaseViewHolder> {
    public UserAdapter(@Nullable List<User> data) {
        super(R.layout.car_view_show, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, User users) {
        baseViewHolder.setText(R.id.showpping_show_view_number,users.age);
    }
}
