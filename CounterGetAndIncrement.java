class CounterGetAndIncrement extends Method {
   int pc;
   int count;
   Counter counter;
   CounterGetAndIncrement(Counter c, int thread) {
      super(thread);
      counter = c;
   }
   public void step() {
      switch(pc) {
         case 0:
         count = counter.value;
         log("count=" + count);
	 pc++;
         break;

	 case 1:
	 ++count;
	 log("++count=" + count);
	 pc++;
	 break;

	 case 2:
	 counter.value = count;
	 log("count.value=" + counter.value);
	 completed = true;
	 break;
      }
   }
   public String getName() {
      return "GetAndIncrement";
   }
}
