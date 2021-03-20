class CounterGetAndIncrementAtomic extends Method {
   int pc;
   int count;
   Counter counter;
   CounterGetAndIncrementAtomic(Counter c, int thread) {
      super(thread);
      counter = c;
   }
   public void step() {
      switch(pc) {
         case 0:
         count = counter.value;
         log("count=" + count);
         ++count;
         log("++count=" + count);
	 counter.value = count;
	 log("count.value=" + counter.value);
	 completed = true;
	 break;
      }
   }
   public String getName() {
      return "GetAndIncrementAtomic";
   }
}
