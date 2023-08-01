package cn.whlit.resb;


/**
 * @author WangHaiLong 2023/5/1 16:54
 */
public abstract class Handler {
    private Handler next;
    //设置下一个处理者
    public void setNext(Handler next) {
        this.next = next;
    }

    //每个处理者都必须对请求做处理
    public final Response handleMessage(Request request){
        Response response = null;
        //判断是否是自己的处理级别
        if (this.getHandlerLevel().equals(request.getLevel())){
            response = this.echo(request);
        }else {
            //不属于自己的级别
            //判断是否有下一个处理者
            if (this.next != null){
                response = this.next.handleMessage(request);
            }else {
                //没有合适的处理者
            }
        }
        return response;
    }
    //每个处理者都必须实现处理任务
    protected abstract Response echo(Request request);
    //每个处理者都有一个处理级别
    protected abstract Level getHandlerLevel();
}
