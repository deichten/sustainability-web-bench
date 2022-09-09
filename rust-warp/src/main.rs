#![deny(warnings)]
use std::collections::HashMap;

use warp::Filter;

#[tokio::main]
async fn main() {
    
    // addition
    let add = warp::path!("add" / i32 / i32).map(|a, b| warp::reply::json(&HashMap::from([("result", a+b)])));

    // substraction
    let sub = warp::path!("sub" / i32 / i32).map(|a, b| warp::reply::json(&HashMap::from([("result", a-b)])));

    // multiplication
    let mul = warp::path!("mul" / i32 / i32).map(|a, b| warp::reply::json(&HashMap::from([("result", a*b)])));

    // division
    let div = warp::path!("div" / i32 / i32).map(|a, b| {
        if b != 0 { 
            warp::reply::json(&HashMap::from([("result", a/b)]))
        } else {
            warp::reply::json(&HashMap::from([("error", "Division by zero")]))
        }
    });


    let math = warp::get().and(warp::path("calc").and(add.or(sub).or(mul).or(div)));

    let (_addr, fut) = warp::serve(math)
        .bind_with_graceful_shutdown(([0, 0, 0, 0], 8080), async move {
            tokio::signal::ctrl_c()
                .await
                .expect("failed to listen to shutdown signal");
        });

    fut.await;

    println!("shutting down");

}
