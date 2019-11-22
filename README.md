Fake Credit Card Generator
==============
[![Build Status](https://travis-ci.com/fakecreditcard/fake-creditcard.svg?branch=master)](https://travis-ci.com/fakecreditcard/fake-creditcard)
[![License](http://img.shields.io/:license-apache-brightgreen.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)


This library have a objective for help a devellopers and testers during the application tests.

For many times is necesary the create a tests for payment validation using the credit card fake and this library is one facilitator for this scenaries.

## Usage
-----------

In pom.xml, add the following xml stanza between `<dependencies> ... </dependencies>`

```xml
<dependency>
  <groupId>com.github.fakecreditcard</groupId>
  <artifactId>fake-creditcard</artifactId>
  <version>1.0.0</version>
</dependency>
```

For gradle users, add the following to your build.gradle file.

```groovy
dependencies {
    implementation 'com.github.fakecreditcard:fake-creditcard:1.0.0'
}

```

In your Java code

```java

Creditcard card = FakeCard.visa();

Creditcard card = FakeCard.master();

```

The return of card genetor is

```java
public class Creditcard {

	private String number;

	private String holderName;

	private String cvv;

	private String expDate;
	
	private String expirationYear;
	
	private String expirationMonth;

}
```


LICENSE
-------
Copyright (c) 2019 Fernando God�y. See the LICENSE file for license rights and limitations.





 

