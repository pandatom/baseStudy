package com.changxiong.State.OrderState;

class PaidState extends AbstractState {

    @Override
    public void feedBackEvent(Context context) {
        context.setState(new FeedBackState());
    }

    @Override
    public String getCurrentState() {
        return StateEnum.PAID.getValue();
    }
}
