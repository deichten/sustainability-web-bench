import express, { Application, Request, Response } from 'express'
import axios from 'axios'

const app: Application = express()

const port: number = 8080
const inetDepencencyUrl = "http://0.0.0.0:3001/compute"

app.get('/net_dependency',(req: Request, res: Response) => {
    axios.get(inetDepencencyUrl).then((response) => res.send(response.data))
})

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
