class MCSLockQNode {
  boolean locked = false;
  MCSLockQNode next = null;
  public String toString() {
    return "locked=" + (locked ? "true " : "false ") + "next=" + (next==null?"null" : "non-null");
  }
};
