package pdp.rest.jersey.mentortask;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class TaskService {
    private Map<Long, TaskEntity> data = new ConcurrentHashMap<>();
    private AtomicLong idGenerator = new AtomicLong(0);

    private static TaskService instance = new TaskService();

    private TaskService() {
    }

    public static TaskService getInstance() {
        return instance;
    }

    public Collection<TaskEntity> get() {
        return data.values();
    }

    public TaskEntity get(long id) {
        return data.get(id);
    }

    public long add(TaskEntity elem) {
        long id = idGenerator.incrementAndGet();
        elem.setId(id);
        data.putIfAbsent(id, elem);
        return id;
    }

    public void update(TaskEntity elem) {
        data.put(elem.getId(), elem);

    }

    public void delete(Long id) {
        data.remove(id);
    }

}
