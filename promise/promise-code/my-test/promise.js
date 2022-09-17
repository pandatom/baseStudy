function Promise(executor) {
  this.status = "pending";
  this.data = null;

  let self = this;
  function resolve(data) {
    if (!self.status === "pending") return;
    self.status = "fillfull";
    self.data = data;
    self.callback.forEach(element => {
      element.onResolve(data) 
    });
    // if (self.callback.onResolve) {
      // self.callback.onResolve(data);
    }
  }

  function reject(data) {
    if (!self.status === "pending") return;
    self.status = "fail";
    self.data = data;
    // if (self.callback.onReject) {
      // self.callback.onReject(data);
    // }
    self.callback.forEach(element => {
      element.onReject(data);
    })
  }

  try {
    executor(resolve, reject);
  } catch (e) {
    reject(e);
  }
}

Promise.prototype.then = function (onResolve, onReject) {
  

  return new Promise((resolve, reject) => {
      if (this.status === "fillfull") {
        let result = onResolve(this.data);
        
        if (result instanceof Promise) {
          result.then(v => {
            resolve(v)
          }, r => {
            reject(r)
          })
        }
      }

      if (this.status == "fail") {
          onReject(this.data);
      }

      if ((this.status = "pending")) {
        this.callback.push({
            onResolve,
            onReject,
          })     
      }
  })

};
