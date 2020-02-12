package edu.cnm.deepdive.justdead.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.justdead.model.entity.Location;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

  @Dao
  public interface LocationDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    Single<Long> insert(Location location);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    Single<List<Long>> insert(Collection<Location> location);

    @Update
    int update(Location location);

    @Delete
    int delete(Location... location);

    @Query("SELECT loc.* FROM Location loc INNER JOIN Notification n ON n.notification_id = loc.notification_id ORDER BY n.battery DESC, loc.time_stamp")
    LiveData<List<Location>> select();


}
