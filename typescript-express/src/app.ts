import express, { Application, Request, Response } from 'express'

const app: Application = express()

const port: number = 8080

app.get('/calc/add/:a/:b', (req: Request, res: Response) => {
    res.send({
        "result": parseInt(req.params.a) + parseInt(req.params.b)
    })
})

app.get('/calc/sub/:a/:b', (req: Request, res: Response) => {
    res.send({
        "result": parseInt(req.params.a) - parseInt(req.params.b)
    })
})

app.get('/calc/mul/:a/:b', (req: Request, res: Response) => {
    res.send({
        "result": parseInt(req.params.a) * parseInt(req.params.b)
    })
})

app.get('/calc/div/:a/:b', (req: Request, res: Response) => {
    let a = parseInt(req.params.a)
    let b = parseInt(req.params.b)

    if (b == 0) {
        res.send({"error": "Division by zero"})
    } else {
        res.send({
            "result": Math.floor(parseInt(req.params.a) / parseInt(req.params.b))
        })
    }
})

app.listen(port, function () {
    console.log(`App is listening on port ${port} !`)
})
