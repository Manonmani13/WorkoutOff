package com.javabrains.Resource;

import org.springframework.web.bind.annotation.ResponseStatus;


import org.springframework.http.HttpStatus;
@ResponseStatus(value=HttpStatus.NOT_FOUND)
 class ResourceNotFoundException {

}
