#!/usr/bin/bash
dr=$(dirname "$0")
pandoc "$dr/supo_work.md" -s -o "$dr/supo_work.pdf" -V geometry:a4paper,margin=1in -V fontsize:12pt "$@"
