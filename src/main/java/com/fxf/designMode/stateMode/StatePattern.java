//package com.fxf.designMode.stateMode;
//
///**
// * @Classname statePattern
// * @Description TODO
// * @Version 1.0.0
// * @Date 2022/4/3 20:49
// * @Created by 饭小范
// */
//// 任务状态抽象接口
//interface State {
//    // 默认实现，不做任何处理
//    default void update(Task task, ActionType actionType) {
//        // do nothing
//    }
//}
//// 任务初始状态
//class TaskInit implements State {
//    @Override
//    public void update(Task task, ActionType actionType) {
//        if  (actionType == ActionType.START) {
//            task.setState(new TaskOngoing());
//        }
//    }
//}
//// 任务进行状态
//class TaskOngoing implements State {
//    private ActivityService activityService;
//    private TaskManager taskManager;
//    @Override
//    public void update(Task task, ActionType actionType) {
//        if (actionType == ActionType.ACHIEVE) {
//            task.setState(new TaskFinished());
//            // 通知
//            activityService.notifyFinished(taskId);
//            taskManager.release(taskId);
//        } else if (actionType == ActionType.STOP) {
//            task.setState(new TaskPaused());
//        } else if (actionType == ActionType.EXPIRE) {
//            task.setState(new TaskExpired());
//        }
//    }
//}
//// 任务暂停状态
//class TaskPaused implements State {
//    @Override
//    public void update(Task task, ActionType actionType) {
//        if (actionType == ActionType.START) {
//            task.setState(new TaskOngoing());
//        } else if (actionType == ActionType.EXPIRE) {
//            task.setState(new TaskExpired());
//        }
//    }
//}
//// 任务完成状态
//class TaskFinished implements State {
//
//}
//// 任务过期状态
//class TaskExpired implements State {
//
//}
//
//class Task {
//    private Long taskId;
//    // 初始化为初始态
//    private State state = new TaskInit();
//    // 更新状态
//    public void updateState(ActionType actionType) {
//        state.update(this, actionType);
//    }
//
//    public Long getTaskId() {
//        return taskId;
//    }
//
//    public void setTaskId(Long taskId) {
//        this.taskId = taskId;
//    }
//
//    public State getState() {
//        return state;
//    }
//
//    public void setState(State state) {
//        this.state = state;
//    }
//}
//
//@AllArgsConstructor
//@Getter
//enum TaskState {
//    INIT("初始化"),
//    ONGOING( "进行中"),
//    PAUSED("暂停中"),
//    FINISHED("已完成"),
//    EXPIRED("已过期")
//    ;
//    private final String message;
//}
//// 行为枚举
//@AllArgsConstructor
//@Getter
//enum ActionType {
//    START(1, "开始"),
//    STOP(2, "暂停"),
//    ACHIEVE(3, "完成"),
//    EXPIRE(4, "过期")
//    ;
//    private final int code;
//    private final String message;
//}
