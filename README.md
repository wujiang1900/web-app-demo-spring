# web-app-demo-spring
My simple web app demo using Spring boot.

A summary of tech stack:
* **Client**: AngularJS and Twitter Bootstrap with pure html partials (no server side rendering so it's fully static and CDN ready). 
* **Server**: Spring MVC and Spring Data on the backend.
* RESTful WS hooks up Angular and Spring.
* Grunt tasks are used to facilitate client side development and testing.
* MongoDB for persistence.
* Spring Data hooks up MongoDB.

## Getting Started
Make sure that you have MongoDB (running on the default port 27017) installed on your computer. 
You also need bower and maven to build the war file.

To build the app, do following:

```bash
git clone https://github.com/wujiang1900/web-app-demo-spring.git
cd web-app-demo-spring/src/main/webapp
bower install
cd ../../..
mvn clean package
```

You will fine the war file in target dir, where you can copy it to your favorite servlet container (e.g. Tomcat).

Then you can access this app from your browser at url like [http://localhost:8080/webAppDemo-1](http://localhost:8080/webAppDemo-1). 

Enjoy!

