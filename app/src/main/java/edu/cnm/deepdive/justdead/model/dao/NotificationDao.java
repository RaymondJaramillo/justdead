package edu.cnm.deepdive.justdead.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import edu.cnm.deepdive.justdead.model.entity.Notification;
import edu.cnm.deepdive.justdead.model.pojo.NotificationHistory;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface NotificationDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(Notification notification);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<Notification> notifications);

  @Update
  int update(Notification notification);

  @Delete
  Single<Integer> delete(Notification... notifications);

  @Query("SELECT * FROM Notification ORDER BY battery")
  LiveData<List<Notification>> selectAll();

  @Transaction
  @Query("SELECT * FROM Notification ORDER BY battery")
  LiveData<List<NotificationHistory>> selectWithHistory();

}
