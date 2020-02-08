package com.nus.duke.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.nus.duke.tasks.Tasks;
import static com.nus.duke.tasks.Tasks.TASK_STATUS;

public class InMemDAO implements DAOInterface {
    private List<Tasks> tasksList = new ArrayList<>();

    @Override
    public Boolean add(Tasks task) {
        this.tasksList.add(task);
        return true;
    }

    @Override
    public Boolean set(Tasks task, TASK_STATUS status) {
        task.changeStatus(status);
        return true;
    }

    @Override
    public Tasks search(String name) {
        Optional<Tasks> task = this.tasksList
                                    .stream()
                                    .filter(eachTask -> name.equals(eachTask.getName()))
                                    .findFirst();

        return task.isPresent() ? task.get() : null;
    }

    @Override
    public Boolean delete(Tasks task) {
        this.tasksList.remove(task);
        return true;
    }

    @Override
    public List<Tasks> getAll() {
        return this.tasksList;
    }
}