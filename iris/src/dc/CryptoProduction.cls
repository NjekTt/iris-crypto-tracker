Class dc.CryptoProduction Extends Ens.Production
{

XData ProductionDefinition
{
<Production Name="dc.CryptoProduction" TestingEnabled="true" LogGeneralTraceEvents="false">
  <Description></Description>
  <ActorPoolSize>2</ActorPoolSize>
  <Item Name="CryptoService" Category="" ClassName="EnsLib.PEX.BusinessService" PoolSize="1" Enabled="true" Foreground="false" Comment="" LogTraceEvents="true" Schedule="">
    <Setting Target="Host" Name="%gatewayPort">55555</Setting>
    <Setting Target="Host" Name="%remoteClassname">Crypto.rmq.CryptoService</Setting>
    <Setting Target="Host" Name="%gatewayExtraClasspaths"></Setting>
    <Setting Target="Host" Name="%remoteSettings"></Setting>
    <Setting Target="Host" Name="%gatewayHost">jgw</Setting>
    <Setting Target="Adapter" Name="CallInterval">60</Setting>
  </Item>
  <Item Name="RequestRoutingRule" Category="" ClassName="EnsLib.MsgRouter.RoutingEngine" PoolSize="1" Enabled="true" Foreground="false" Comment="" LogTraceEvents="false" Schedule="">
    <Setting Target="Host" Name="BusinessRuleName">dc.RequestRoutingRule</Setting>
  </Item>
</Production>
}

}
