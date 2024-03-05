@echo off
REM Parar e remover contêineres existentes
echo Parando e removendo contêineres existentes...
docker-compose down

REM Remover volumes antigos (se necessário)
echo Removendo volumes antigos...
docker volume prune -f

REM Remover caches ou outros artefatos (se necessário)
echo Removendo caches...
REM Comando para limpar caches

REM Iniciar contêineres
echo Iniciando contêineres...
docker-compose up -d

REM Aguardar alguns segundos antes de sair
timeout /t 5 /nobreak >nul
