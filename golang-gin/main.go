package main

import (
	"strconv"

	"github.com/gin-gonic/gin"
)

func main() {
	r := gin.Default()

	// addition module
	r.GET("/calc/add/:first/:second", func(c *gin.Context) {
		first, ferr := strconv.Atoi(c.Param("first"))
		second, serr := strconv.Atoi(c.Param("second"))
		if ferr != nil || serr != nil {
			c.JSON(404, gin.H{"error": "unparsable"})
		} else {
			c.JSON(200, gin.H{
				"result": first + second,
			})
		}
	})

	// substraction module
	r.GET("/calc/sub/:first/:second", func(c *gin.Context) {
		first, ferr := strconv.Atoi(c.Param("first"))
		second, serr := strconv.Atoi(c.Param("second"))
		if ferr != nil || serr != nil {
			c.JSON(404, gin.H{"error": "unparsable"})
		} else {
			c.JSON(200, gin.H{
				"result": first - second,
			})
		}
	})

	// multiplication module
	r.GET("/calc/mul/:first/:second", func(c *gin.Context) {
		first, ferr := strconv.Atoi(c.Param("first"))
		second, serr := strconv.Atoi(c.Param("second"))
		if ferr != nil || serr != nil {
			c.JSON(404, gin.H{"error": "unparsable"})
		} else {
			c.JSON(200, gin.H{
				"result": first * second,
			})
		}
	})

	// division module
	r.GET("/calc/div/:first/:second", func(c *gin.Context) {
		first, ferr := strconv.Atoi(c.Param("first"))
		second, serr := strconv.Atoi(c.Param("second"))
		if ferr != nil || serr != nil {
			c.JSON(404, gin.H{"error": "unparsable"})
		} else if second == 0 {
			c.JSON(404, gin.H{
				"error": "Division by zero",
			})
		} else {
			c.JSON(200, gin.H{
				"result": first / second,
			})
		}
	})

	// start on 8080
	r.Run(":8080")
}
