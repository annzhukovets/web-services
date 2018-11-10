exports.handler = function (event, context) {
    if (Math.random() < event.accuracy) {
        result = Object();
        result.id = event.id;
        result.money = "1000";
        context.succeed(result);
    } else {
        result = Object();
        result.id = event.id;
        result.money = "0";
        context.succeed(result);
    }
};
