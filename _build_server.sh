#!/usr/bin/bash

# This build system auto-restarting server, all for some supo work...
# What am I doing with my life?!
ivalmax=600
ctr=0
# pf=0
nt=0
lh=0
bsch=$(sha256sum "$0")
bscript=_build_pdf.sh
while true; do 
    if [ "$bsch" != "$(sha256sum "$0")" ]; then
        echo "Detected change in _build_server.sh, restarting..."
        exec bash "$0" 
    fi
    ct=$(date +%s)
    ch=$(sha256sum "$bscript" supo_work.md | sha256sum)
    if [ "$ct" -ge "$nt" ] || [ "$ch" != "$lh" ]; then
        ctr=$(( ctr + 1))
        lh="$ch"
        nt=$(( ct + ivalmax ))
        echo -ne "\rBuilding build $(printf %4d $ctr)"
        if bash "$bscript"; then
            echo -e "\rFinished build $(printf %4d $ctr)"; 
            # if [ $pf -ne 0 ]; then 
            #     echo ""
            # fi
            # pf=0
        else 
            echo "FAILED build   $(printf %4d $ctr)"
            # pf=1
        fi
    fi
done
