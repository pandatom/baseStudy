package com.changxiong.State.OrderState;

//各种具体状态类
class FeedBackState extends AbstractState {

    @Override
    public String getCurrentState() {
        return StateEnum.FEED_BACKED.getValue();
    }
}
