"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const express_1 = __importDefault(require("express"));
const axios_1 = __importDefault(require("axios"));
const app = (0, express_1.default)();
const port = 8082;
const inetDepencencyUrl = "http://0.0.0.0:3001/compute";
app.get('/net_dependency', (req, res) => {
    axios_1.default.get(inetDepencencyUrl).then((response) => res.send(response.data));
});
app.get('/calc/add/:a/:b', (req, res) => {
    res.send({
        "result": parseInt(req.params.a) + parseInt(req.params.b)
    });
});
app.get('/calc/sub/:a/:b', (req, res) => {
    res.send({
        "result": parseInt(req.params.a) - parseInt(req.params.b)
    });
});
app.get('/calc/mul/:a/:b', (req, res) => {
    res.send({
        "result": parseInt(req.params.a) * parseInt(req.params.b)
    });
});
app.get('/calc/div/:a/:b', (req, res) => {
    let a = parseInt(req.params.a);
    let b = parseInt(req.params.b);
    if (b == 0) {
        res.send({ "error": "Division by zero" });
    }
    else {
        res.send({
            "result": Math.floor(parseInt(req.params.a) / parseInt(req.params.b))
        });
    }
});
app.listen(port, function () {
    console.log(`App is listening on port ${port} !`);
});
