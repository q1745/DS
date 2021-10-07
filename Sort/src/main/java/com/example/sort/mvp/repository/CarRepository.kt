package com.example.sort.mvp.repository

import com.example.mvpcore.BaseRepository
import com.example.protocol.BaseReposEntity
import com.example.sort.mvp.model.CarModel
import com.example.sort.mvp.model.entity.CarEntity
import io.reactivex.Observer
import javax.inject.Inject

/**
@CreateDate: 2021/9/23 15:55
@name:haonan
@Contact information:qq by 1612258670
@ProjectName: DS
@Package: com.example.sort.mvp.repository
@ClassName: CarRepository
 */
class CarRepository @Inject constructor():BaseRepository() {
   fun success(observable: Observer<BaseReposEntity<CarEntity>>){
       (models.get("carModel") as CarModel).carList(observable)
   }
}