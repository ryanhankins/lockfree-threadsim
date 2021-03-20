class MCSLockQNode {
  boolean locked = false;
  MCSLockQNode next = null;
  public String toString() {
    return "[this=" + getAddrString() +
	   " locked=" + (locked ? "true " : "false ") + "next=" +
	   ((next == null) ? "null" : next.getAddrString()) + "]";
  }
  public String getAddrString() {
    return String.format("0x%08X", this.hashCode());
  }
};
