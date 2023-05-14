package scripting;

final class a implements Runnable
{
  private final /* synthetic */ int cx;
  private final /* synthetic */ int cz;
  private final /* synthetic */ AbstractPlayerInteraction a;
  
  a(final AbstractPlayerInteraction a, final int cx, final int cz)
  {
    this.a = a;
    this.cx = cx;
    this.cz = cz;
  }
  
  @Override
  public void run()
  {
    if (this.a.getPlayer() != null && this.a.getPlayer().getMapId() == this.cx)
    {
      this.a.warp(this.cz, 0);
    }
  }
}
