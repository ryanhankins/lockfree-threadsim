class Sleep extends Method {
   int steps;
   int pc = 0;
   Sleep(int s, int t) {
      super(t);
      steps = s;
   }
   public void step() {
      if (pc++ < steps) {
	log("");
      } else {
        completed = true;
      }
   }
   public String getName() {
      return "Sleep";
   }
   public boolean isCompleted() {
      return completed;
   }
   public int getIndent() {
      return 0;
   }
}
