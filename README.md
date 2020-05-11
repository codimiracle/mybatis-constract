# Backend Componet - MyBatis Contract

[![Build Status](https://travis-ci.org/codimiracle/mybatis-contract.svg?branch=master)](https://travis-ci.org/codimiracle/mybatis-contract)

provides very useful class definitions for mybatis persistence framework.

## Features
* Basic PO Support
* Extends VO Support
* MyBatis integrated
    * MyBatis PageHelper
 * LogicDelete Enhanced

## Installation
Maven:
```xml
<dependency>
    <groupId>com.codimiracle.web</groupId>
    <artifactId>mybatis-contract</artifactId>
    <version>1.0.1-SNAPSHOT</version>
</dependency>
```
Gradle: (TODO)

Manual:
1. clone the repo
2. using maven compile and install
3. import in the project

## Usages
Basically, you can extends the AbstractService (VO supported in the support.vo package.)
```java
// ExampleService
// omits MyBatis Mapper class and Mapper.xml
class ExampleService extends AbstractService<Long, Example> {}
```
