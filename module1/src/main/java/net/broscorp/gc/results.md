1. When we don't lose object references, GC won't work and finalize method won't work
2. When we lose objects references then GC will work and finalize method will work
   Apr 26, 2022 9:40:35 PM net.broscorp.gc.GCMain finalize
   INFO: Finalize method worked
3. When two objects references each other finalize method won't work and GC won't work too.
   GC won't work and finalize method won't work
4. When two objects references each other and when we make the objects achievable again after we call the finalize method